require recipes-kernel/linux/linux-bananapi.inc
DESCRIPTION = "Linux Kernel For Bananapi"
KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "bananapi"

KERNEL_DEVICETREE = "sunxi-bananapi-m2-plus.dtb"

PV = "5.9"
PR = ""

SRCREV_pn-${PN} = "${AUTOREV}"

SRC_URI += " git://github.com/torvalds/linux.git;protocol=https"

S = "${WORKDIR}/git/"
LDFLAGS = ""
TARGET_LDFLAGS = ""
B = "${S}"
