#!/bin/bash
ssh $SU@$SH \
  'cd ~/minecraft; git checkout .; git pull origin master; ./restart.sh || :'
