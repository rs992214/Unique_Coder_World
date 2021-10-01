#!/bin/bash

domain=$1
wordlist="/root/dict./SecLists/Discovery/DNS/fierce-hostlist.txt"
resolvers="/root/recon/dnsvalidator/resolvers.txt"

domain_enum(){

mkdir -p $domain $domain/sources $domain/Recon $domain/Recon/nuclei $domain/Recon/URLs $domain/Recon/Gf-Patterns $domain/Recon/PortScan $domain/Recon/jaeles $domain/Recon/js/

subfinder -d $domain -o $domain/sources/subfinder.txt
assetfinder -subs-only $domain | tee $domain/sources/assetfinder.txt
amass enum -passive -d $domain -o $domain/sources/passive.txt
shuffledns -d $domain -w $wordlist -r $resolvers -o $domain/sources/shufflends.txt

cat $domain/sources/*.txt > $domain/sources/all.txt
}
domain_enum

resolving_domains(){
shuffledns -d $domain -list $domain/sources/all.txt -o $domain/domains.txt -r $resolvers
}
resolving_domains

http_prob(){
cat $domain/domains.txt | httpx -threads 200 -o $domain/Recon/httpx.txt
}
http_prob

wayback_url(){
cat $domain/domains.txt | waybackurls | tee $domain/Recon/URLs/urls.txt
cat $domain/Recon/URLs/urls.txt | egrep -v "\.ico|\.jpg|\.svg|\.css|\.png|\.woff|\.woff2|\.gif|\.ttf|\.jpeg|\.eot" | sed 's/:80//g;s/:433//g' | sort -u > $domain/Recon/URLs/wayback_url.txt
rm $domain/Recon/URLs/urls.txt
}
wayback_url

vaild_url(){
ffuf -c -u "FUZZ" -w $domain/Recon/URLs/wayback_url.txt -mc 200 -of csv -o $domain/Recon/URLs/vaild-temp.txt
cat $domain/Recon/URLs/vaild-temp.txt | grep http | awk -F "," '{print $1}' >> $domain/Recon/URLs/vaild.txt
rm $domain/Recon/URLs/vaild-temp.txt
}
vaild_url

js_file(){
cat $domain/Recon/httpx.txt | gau | grep ".js$" | uniq | sort >> $domain/Recon/js/jsfile_links.txt
cat $domain/Recon/httpx.txt | subjs >> $domain/Recon/js/jsfile_links.txt
cat $domain/Recon/js/jsfile_links.txt | hakcheckurl | grep "200" | cut -d" " -f2 | sort -u > $domain/Recon/js/live_jsfile_links.txt
cat $domain/Recon/js/live_jsfile_links.txt | while read url;do python3 /root/recon/secretfinder/SecretFinder.py -i $url -o cli >> $domain/Recon/js/jsSecrete.txt ;done 
}
js_file

nmap_scan(){
nmap --script vuln -iL $domain/domains.txt -oX $domain/Recon/PortScan/Port.xml
xsltproc $domain/Recon/PortScan/Port.xml -o $domain/Recon/PortScan/port.html
}
nmap_scan

subdomain_takeover(){
subjack -w $domain/sources/all.txt -t 20 -ssl -c ~/go/src/github.com/haccer/subjack/fingerprints.json -v 3 -o $domain/Recon/subjack.txt
}
subdomain_takeover

aquatone_scan(){
aquatone-discover -d $domain --disable-collectors dictionary
aquatone-scan -d $domain
aquatone-takeover -d $domain
}
aquatone_scan

knockpy_scan(){
knockpy $domain
}
knockpy_scan

Gf-Patterns(){
gf xss $domain/Recon/URLs/vaild.txt | tee $domain/Recon/Gf-Patterns/xss.txt
gf sqli $domain/Recon/URLs/vaild.txt | tee $domain/Recon/Gf-Patterns/sqli.txt
gf lfi $domain/Recon/URLs/vaild.txt | tee $domain/Recon/Gf-Patterns/lfi.txt
gf ssrf $domain/Recon/URLs/vaild.txt | tee $domain/Recon/Gf-Patterns/ssrf.txt
gf redirect $domain/Recon/URLs/vaild.txt | tee $domain/Recon/Gf-Patterns/redirect.txt
gf idor $domain/Recon/URLs/vaild.txt | tee $domain/Recon/Gf-Patterns/idor.txt
gf rce $domain/Recon/URLs/vaild.txt | tee $domain/Recon/Gf-Patterns/rce.txt
}
Gf-Patterns

nuclei_vul(){
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/cves -o $domain/Recon/nuclei/cves.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/vulnerabilities -o $domain/Recon/nuclei/vulnerabilities.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/files -o $domain/Recon/nuclei/files.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/technologies -o $domain/Recon/nuclei/technologies.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/security-misconfiguration -o $domain/Recon/nuclei/security-misconfiguration.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/subdomain-takeover -o $domain/Recon/nuclei/subdomain-takeover.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/tokens -o $domain/Recon/nuclei/tokens.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/default-credentials -o $domain/Recon/nuclei/default-credentials.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/payloads -o $domain/Recon/nuclei/payloads.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/dns -o $domain/Recon/nuclei/dns.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/panels -o $domain/Recon/nuclei/panels.txt
cat $domain/Recon/httpx.txt | nuclei -t /root/nuclei-templates/generic-detections -o $domain/Recon/nuclei/generic-detections.txt
}
nuclei_vul

jaeles_scan(){
cat $domain/Recon/httpx.txt | jaeles scan -c 50 -s /tmp/jaeles-signatures/cves -L 50 -v -o $domain/Recon/jaeles/cve.txt
cat $domain/Recon/httpx.txt | jaeles scan -c 50 -s /tmp/jaeles-signatures/common -L 50 -v -o $domain/Recon/jaeles/common.txt
cat $domain/Recon/httpx.txt | jaeles scan -c 50 -s /tmp/jaeles-signatures/fuzz -L 50 -v -o $domain/Recon/jaeles/fuzz.txt
cat $domain/Recon/httpx.txt | jaeles scan -c 50 -s /tmp/jaeles-signatures/mics -L 50 -v -o $domain/Recon/jaeles/mics.txt
cat $domain/Recon/httpx.txt | jaeles scan -c 50 -s /tmp/jaeles-signatures/passives -L 50 -v -o $domain/Recon/jaeles/passives.txt
cat $domain/Recon/httpx.txt | jaeles scan -c 50 -s /tmp/jaeles-signatures/probe -L 50 -v -o $domain/Recon/jaeles/probe.txt
cat $domain/Recon/httpx.txt | jaeles scan -c 50 -s /tmp/jaeles-signatures/sensitive -L 50 -v -o $domain/Recon/jaeles/sensitive.txt
}
jaeles_scan
