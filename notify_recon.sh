#!/usr/bin/bash
echo "

";
nuclei --update-templates --silent

read -p "Enter domain names seperated by 'space': " input
for i in ${input[@]}
do

echo "
.
.
.
Scan Started for $i
" | notify --silent

mkdir $i

subfinder -d $i | httpx >> $i/subdomains.txt

echo "Subdomains saved at $i/subdomains.txt" | notify

echo "Scan for CVES started." | notify
nuclei -l $i/subdomains.txt -t cves/ -o $i/cves.txt | notify
echo "Scan for CVES completed." | notify

echo "Scan for default-logins started." | notify
nuclei -l $i/subdomains.txt -t default-logins/ -o $i/default-logins.txt | notify
echo "Scan for default-logins completed." | notify

echo "Scan for exposures started." | notify
nuclei -l $i/subdomains.txt -t exposures/ -o $i/exposures.txt | notify
echo "Scan for exposures completed." | notify

echo "Scan for misconfigurations started." | notify
nuclei -l $i/subdomains.txt -t misconfiguration/ -o $i/misconfiguration.txt | notify
echo "Scan for misconfigurations completed."| notify

echo "Scan for takeovers started."| notify
nuclei -l $i/subdomains.txt -t takeovers/ -o $i/takeovers.txt | notify
echo "Scan for takeovers completed."| notify

echo "Scan for vulnerability started."| notify
nuclei -l $i/subdomains.txt -t vulnerabilities/ -o $i/vulnerabilities.txt | notify
echo "Scan for vulnerability completed."| notify


echo "
.
.
.
Scan finished for $i
" | notify --silent
done
