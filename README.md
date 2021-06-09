# Minecraft K3s Pi

A repo to track customizations to my Minecraft Server running on my Rasphberry Pi kubernetes cluster. Might have a little block lag.

## Prequisites

- Rasphberry Pi with at least 4GB RAM
- k3s installed on that Pi
- helm and kubectl set up on your computer

## Local Usage

- Customize values.yaml or replace the resource pack
- `./release.sh`

## Github Actions

Should automatically run on merge to main and update the server.

## Reference

- Server Values: <https://github.com/itzg/minecraft-server-charts/blob/master/charts/minecraft/values.yaml>
- Additional Customizations using `extraEnv` in values.yaml: <https://github.com/itzg/docker-minecraft-server>. Look at RESOURCE_PACK in values.yaml, adding more items like that results in the customizations outlines in that repository's readme.
