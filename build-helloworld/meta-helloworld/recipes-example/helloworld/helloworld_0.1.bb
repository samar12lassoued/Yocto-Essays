SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "CLOSED"

SRC_URI = "file://hello-world.c"

S = "${WORKDIR}"
do_compile() {

#${CC} ${CFLAGS} ${LDFLAGS} hello-world.c -o helloworld
${CC} hello-world.c ${LDFLAGS} -o myhello
}
do_install() {
install -d ${D}${bindir}
install -m 0755 myhello ${D}${bindir}/myhello
}
