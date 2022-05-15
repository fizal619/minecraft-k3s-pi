#!/bin/bash

helm repo add itzg https://itzg.github.io/minecraft-server-charts/

helm upgrade minecraft --install -f values.yaml itzg/minecraft --version 3.8.1

