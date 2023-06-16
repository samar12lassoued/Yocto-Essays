# Yocto-Essays

## This repository aims to  initial startup and learning purposes for  Yocto Build System 

# First Yocto Project Build For QEMU (Quick Emulator)  

This tutorial is a simple example of integrating a c program into an image using yocto.
The following instructions will guide you through  and you'll  learn how to set up a host system for Yocto Project development and what are the basic steps to generate an image for QEMU (Quick Emulator).
You don’t require any extra hardware for the QEMU emulator build. You need to verify the build by running the QEMU emulator on the host system only.


# Yocto Project setup and Build steps
There are below steps to create custom Linux for the target board using the Yocto Project. we will build the image for QEMU and verify it on host system.


1. Pre-requirement
2. Download Poky
3. Build environment setup
4. Variable configuration in conf/local.conf
5. Launch Yocto build system (Bitbake)
6. Run qemux86-64 image


## Pre-Requirement
To support the Yocto Project build process, you need to follow the below points.

It is recommended to host system should be Ubuntu version 14.04 LTS or Later.
At least a minimum of 50 GB free left in your system.
Internet connection required to download the packages on local disk and reuse for the later build process.
The host system required some packages to support Yocto Project development. It depends on your Linux Distribution.
Run the below command to install the required packages on the host system.

### On Ubuntu Host system: 
```
$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping libsdl1.2-dev xterm
```

## Download Poky
Now your Build host is ready and you need to download poky form Yocto project repository. it is always recommended to use the latest version of poky.
```
$ git clone git://git.yoctoproject.org/poky
$ git checkout kirkstone 
```

## Build Environment Setup 

Run the "oe-init-build-env" script to initialize the built environment and it creates the build directory in the poky folder.
```
$ source poky/oe-init-build-env
```

This command creates a build directory inside the poky and it would be your current working directory.


## Variable Configuration in conf/local.conf

fter setup the build environment, this file is auto-created and it is a user-based configuration for the Yocto build system.

In the build directory, another subdirectory conf is created which consists of two configuration files bblayer.conf and local.conf 
This time we need to look into the local.conf which is the user based configuration file for the Yocto build system.
For QEMU emulator, by default machine variable is set to qemux86-64 and comment on all other MACHINE variables if not

```
$ vim conf/local.conf
```

#For QEMU emulator, the machine variable should qemux86-64
```
MACHINE ??= “qemux86-64”
```


## Launch Yocto Build System (Bitbake)

Launch the Bitbake from build directory. it is the task executer in Yocto Project.

* Always Run the bitbake from the build directory. 
* core-image-minimal provides a very basic console type bootable image.
* Run below command to lunch the bitbake.

```
$ bitbake core-image-minimal
```
### Note: It took several hours to complete. it depends on the number of CPU cores and internet speed. 


## Run qemux86-64 image

After completing the build process, it generates the image for your target board.

```
$ runqemu qemux86-64 
```