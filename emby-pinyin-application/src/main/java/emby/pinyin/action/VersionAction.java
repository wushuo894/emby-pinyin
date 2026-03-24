package emby.pinyin.action;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import emby.pinyin.annotation.Path;
import emby.pinyin.util.MavenUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/version")
public class VersionAction implements BaseAction {
    @Override
    public void doAction(HttpServerRequest request, HttpServerResponse response) {
        resultSuccess(MavenUtil.getVersion());
    }
}
