#!/bin/sh -e

zipfile=$1

unzip -l $zipfile
echo
echo '[press enter to unzip and convert as app]'
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
projname=$(ls $workdir | head -n 1)
mv $workdir/$projname $projname
cp FragmentsLab/build.gradle $projname
test -d $projname/libs || cp -r FragmentsLab/libs $projname
mkdir -p $projname/src/main/java
mv $projname/src/course $projname/src/main/java
mv $projname/AndroidManifest.xml $projname/src/main || :
mv $projname/ic_launcher-web.png $projname/src/main || :
mv $projname/assets $projname/src/main || :
mv $projname/res $projname/src/main/res || :
rm -f $projname/project.properties
mv $projname/proguard-project.txt $projname/proguard-rules.txt || :

cleanup
