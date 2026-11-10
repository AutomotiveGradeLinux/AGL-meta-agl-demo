SUMMARY = "Renesas V4H Xen AGL IVI domu configuration & systemd unit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://domu-agl-ivi.service \
	   file://domu-agl-ivi.cfg \
"

S = "${UNPACKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} = "domu-agl-ivi.service"

do_compile[noexec] = "1"

do_install() {
    install -d ${D}${sysconfdir}/xen
    install -m 0644 ${UNPACKDIR}/domu-agl-ivi.cfg ${D}${sysconfdir}/xen/

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${UNPACKDIR}/domu-agl-ivi.service ${D}${systemd_unitdir}/system/
}

FILES:${PN} += "${systemd_system_unitdir}"

RDEPENDS:${PN} += "launch-domain backend-ready"
