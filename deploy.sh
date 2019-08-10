#!/bin/bash
ssh $SU@$SH \
  'cd ~/minecraft; git pull origin master; sudo systemctl stop minecraft; sudo systemctl start minecraft'
