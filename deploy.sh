#!/bin/bash
ssh $SU@$SH \
  'cd ~/minecraft; git checkout .; git pull origin master; ./stop.sh; ./start.sh; exit'
