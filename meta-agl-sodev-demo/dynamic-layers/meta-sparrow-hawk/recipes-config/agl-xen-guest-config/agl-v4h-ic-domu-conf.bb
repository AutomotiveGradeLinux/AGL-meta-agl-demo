SUMMARY = "Renesas V4H Xen AGL IC domu configuration & systemd unit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://domu-agl-ic.service \
	   file://domu-agl-ic.cfg \
"

S = "${UNPACKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} = "domu-agl-ic.service"

do_compile[noexec] = "1"

do_install() {
    install -d ${D}${sysconfdir}/xen
    install -m 0644 ${UNPACKDIR}/domu-agl-ic.cfg ${D}${sysconfdir}/xen/

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${UNPACKDIR}/domu-agl-ic.service ${D}${systemd_unitdir}/system/
}

FILES:${PN} += "${systemd_system_unitdir}"

RDEPENDS:${PN} += "launch-domain backend-ready"
