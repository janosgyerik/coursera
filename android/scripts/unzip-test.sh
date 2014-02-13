#!/bin/sh -e

zipfile=$1

unzip -l $zipfile
echo
echo '[press enter to unzip and convert as test app]'
read

workdir=unzip-$$
cleanup() {
    rmdir $workdir
}
trap 'cleanup; exit 1' 1 2 3 15

unzip -d $workdir $zipfile
find $workdir -name .DS_Store -delete
find $workdir -name bin -delete
find $workdir -name gen -delete
find $workdir -type f -exec chmod -x {} \;
find $workdir -name .classpath -delete
find $workdir -name .project -delete

alias mv='mv -v'
testname=$(ls $workdir | head -n 1)
projname=${testname%Test}
mkdir -p $projname/src/instrumentTest/java
mv $workdir/$testname/src/course $projname/src/instrumentTest/java
cp -rv $workdir/$testname/libs/* $projname/libs

cleanup
