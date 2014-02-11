#!/bin/sh -e

zipfile=$1

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

projname=$(ls $workdir)
(cd $workdir/$projname; android update project --path . -n $projname)

mv -v $workdir/$projname .

cleanup
