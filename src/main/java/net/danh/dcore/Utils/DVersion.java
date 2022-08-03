package net.danh.dcore.Utils;

public abstract class DVersion {

    public abstract String getOriginalVersion();

    public abstract String getDevBuildVersion();

    public abstract Boolean isDevBuild();

    public abstract Boolean isPremium();

    public abstract String getReleaseLink();

}

