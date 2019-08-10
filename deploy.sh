#!/bin/bash
ssh $SU@$SH \
  'cd ~/minecraft; git pull origin master; ./restart.sh'
