#!/bin/bash
ssh -o StrictHostKeyChecking=no $SU@$SH \
  'cd ~/minecraft; git checkout .; git pull origin master; ./stop.sh; curl --output paperclip.jar -L https://papermc.io/api/v1/paper/1.15.1/25/download; ./start.sh; exit'
