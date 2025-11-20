FROM eclipse-temurin:21-noble

ENV DEBIAN_FRONTEND=noninteractive
ENV TZ=Asia/Tokyo

RUN apt-get update && apt-get install -y \
    git \
    vim \
    nano \
    curl \
    sudo \
    && rm -rf /var/lib/apt/lists/*

ARG USERNAME=dev
RUN userdel -r ubuntu || true && \
    useradd -m -s /bin/bash ${USERNAME} && \
    echo "${USERNAME} ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers
USER ${USERNAME}