DESCRIPTION = "U-Boot Configured For Sunxi"
require recipes-bsp/u-boot/u-boot.inc
DEPENDS += " bc-native dtc-native swig-native python3-native"
LICENSE = "GPLv2"
COMPATIBLE_MACHINE = "bananapi"

PV = "2020.10"
PR = ""

SRC_URI = "git://github.com/u-boot/u-boot.git;protocol=https \
		   file://boot.cmd"
SRCREV = "050acee119b3757fee3bd128f55d720fdd9bb890"

S = "${WORKDIR}/git"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

EXTRA_OEMAKE += ' HOSTLDSHARED="${BUILD_CC} -shared ${BUILD_LDFLAGS} ${BUILD_CFLAGS}" '

do_compile_append() {
	${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
