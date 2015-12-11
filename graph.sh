#!/bin/bash
#PBS -l nodes=2:ppn=32:dc2
#PBS -l walltime=24:00:00
module load ccm
cd /ConsistentSubGraph/src/com/B503/
ccmrun javac *.java
cd ../..
ccmrun java com/B503/DAG
