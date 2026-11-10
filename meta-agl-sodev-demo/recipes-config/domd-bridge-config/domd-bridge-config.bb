SUMMARY     = "Setting files for QEMU bridge networking for guest domains"
LICENSE     = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd allarch

SRC_URI = "file://bridge.conf \
	   file://dnsmasq-qemu.conf \
"

S = "${UNPACKDIR}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    # Install QEMU bridge configuration
    install -d ${D}${sysconfdir}/qemu
    install -m 0644 ${UNPACKDIR}/bridge.conf ${D}${sysconfdir}/qemu/

    # Configure dnsmasq to serve DHCP to the guests
    install -d ${D}${sysconfdir}/dnsmasq.d
    install -m 0644 ${UNPACKDIR}/dnsmasq-qemu.conf ${D}${sysconfdir}/dnsmasq.d/
}

RDEPENDS:${PN} += "qemu-common dnsmasq"
