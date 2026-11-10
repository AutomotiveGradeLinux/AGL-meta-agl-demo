SUMMARY = "Input device output assignment udev configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://99-bind-input-devices.rules"

S = "${UNPACKDIR}"

do_compile[noexec] = "1"

do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${UNPACKDIR}/99-bind-input-devices.rules ${D}${sysconfdir}/udev/rules.d/
}
