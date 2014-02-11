#!/bin/sh -e

zipfile=$1

unzip -l $zipfile
echo
echo '[press enter to go ahead and unzip as instructions]'
read

workdir=unzip-$$
cleanup() {
    rmdir $workdir
}
trap 'cleanup; exit 1' 1 2 3 15

targetdir=tmp
mkdir -p $targetdir

unzip -d $workdir $zipfile
find $workdir -name .DS_Store -delete
rm -fr $workdir/__MACOSX
find $workdir -name '*.zip' -exec mv {} $targetdir/ \;
find $workdir -name '*.pdf' -exec mv {} $targetdir/ \;
find $workdir -depth -exec rmdir {} \;
