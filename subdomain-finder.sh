#!/bin/bash

#Rada
#COLORS
BOLD="\e[1mBold"
NORMAL="\e[0m"
GREEN="\e[92m"

echo -e "${GREEN}[+]Subdomain Enumeretion"

#Assetfinder
echo -e "${GREEN}[+]Starting Assetfinder"
assetfinder --subs-only $1 |sort -u |tee assetfinder.txt | notify

#Sublist3r
echo -e "${GREEN}[+]Starting Sublist3r"
python ~/recon/subdomain/Sublist3r/sublist3r.py -d $1 -o sublister.txt | notify

#Filtering
echo -e "${GREEN}[+]Starting Filtering"
cat sublist3r.txt assetfinder.txt | sort -u |uniq -u| grep -v "*" |sort -u|tee FinalSubs.txt | notify

#Httprobe
echo -e "${GREEN}[+]Starting Httprobe"
cat Final-Subs.txt |sort -u |uniq -u|httprobe|tee $1-alive.txt | notify

#Get-Tilie
echo -e "${GREEN}[+]Starting Get-titles"
cat $1-alive.txt|get-titles | notify

echo -e "${GREEN}[+]Start Subdomain Tackeover Scan"
subjack -w Final-Subs.txt -t 20 -ssl -c ~/go/src/github.com/haccer/subjack/fingerprints.json -v 3 -o subjack.txt | notify
subzy -targets Final-Subs.txt -hide_fails --verify_ssl -concurrency 20 |sort -u|tee "subzy.txt" | notify

echo -e "${GREEN}[+]Aquatone Screenshot"
cat $1-alive.txt| aquatone -screenshot-timeout 10 -out screenshots/ | notify

echo -e "${GREEN}[+]Finish"

rm sublist3r.txt assetfinder.txt

#subfinder

echo "target.com" | subfinder -q -o Output.txt #output will be saved in text file
