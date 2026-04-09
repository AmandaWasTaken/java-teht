#! /usr/bin/env bash

if [[ -f Main.java ]]; then
	javac Main.java
	java Main
else
	printf "Main.java not found\n"
	exit 1
fi

