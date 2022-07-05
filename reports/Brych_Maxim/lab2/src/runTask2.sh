#!/bin/bash
clear
echo "---------Starting Script---------"
echo
echo "---------Generating Class---------"
javac Lab2.java
echo
echo "---------Run Class---------"
java Lab2 task2 head syslog.txt
