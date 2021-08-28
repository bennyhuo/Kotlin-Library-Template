package {{cookiecutter.package_name}}.sample

import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("{{cookiecutter.module_name}}")

fun main() {
    logger.debug("Hello World!")
}