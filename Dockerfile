FROM  registry.cn-zhangjiakou.aliyuncs.com/yunli_mid_platform/openjdk:8-alpine

MAINTAINER jiangtao@yunli

ENV SW_AGENT_NAME="echlogy-fts" TZ="Asia/Shanghai" HOME="/apps" JAVA_OPTS=$JAVA_OPTS JAVA_AGENT_OPTS=$JAVA_AGENT_OPTS

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

RUN apk add --update font-adobe-100dpi ttf-dejavu fontconfig \
    && apk add -U tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo ${TZ} > /etc/timezone \
    && mkdir ${HOME}

ADD target/ecology-fts.jar ${HOME}/app.jar

WORKDIR ${HOME}

EXPOSE 9090

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom $JAVA_AGENT_OPTS -jar app.jar" ]