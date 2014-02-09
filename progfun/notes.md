sbt commands
------------
Run "sbt" inside the scala project directory.

- compile
- test
- styleCheck
- console: run the scala interactive interpreter (= REPL)


Setup vim for Scala
-------------------

    cd ~/.vim/bundle
    git clone https://github.com/derekwyatt/vim-scala


Install Scala using macports
----------------------------

    sudo port selfupdate
    sudo port install sbt
    sudo port install scala2.10
    sudo port select --set scala2.10


Bugs in Eclipse
---------------
- Organize imports removes JUnitRunner import line
    - you can add it back using the Ctrl-1 quick fix, but it does it in an ugly way--a cosmetic issue
- Double-click on unit test case in JUnit window pops up an error. After that it opens the test suite file, but it cannot jump to the right test case
