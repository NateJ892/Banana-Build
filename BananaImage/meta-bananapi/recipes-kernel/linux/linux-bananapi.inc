DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

inherit kernel siteinfo

do_configure() {
	oe_runmake sunxi_defconfig -C ${S} O=${B}
}

do_compile() {
	oe_runmake zImage
}

PACKAGES =+ "kernel-headers "
FILES_kernel-headers = "${exec_prefix}/src/linux*"
