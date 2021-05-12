# Java Example repository

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This repository has simple java applications. Each branch has a new application

## Dependencies
- Docker
- GNU make
## Download openjdk image to docker
```bash
$ docker pull openjdk
```
## Build java application
```bash
$ make
```

## Running Application
```bash
$ make run
```

## Cleaning the .class files
```bash
$ make clean
```
## Change among Apps
Each simple java application stay in a different branch.
To change among applications it's only necessary change the branch

```bash
$ git branch #To list all branches
$ git checkout <APP_BRANCH>
```

