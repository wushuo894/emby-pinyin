package emby.pinyin.action;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import com.google.gson.JsonArray;
import emby.pinyin.annotation.Path;
import emby.pinyin.entity.Views;
import emby.pinyin.task.PinyinTask;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
@Path("/pinyin")
public class PinyinAction implements BaseAction {

    @Override
    public synchronized void doAction(HttpServerRequest request, HttpServerResponse response) throws IOException {
        if (PinyinTask.LOCK.isLocked()) {
            resultErrorMsg("请等待现有任务完成");
        }

        List<Views> viewsList = getBody(JsonArray.class).asList().stream().map(o -> gson.fromJson(o, Views.class)).toList();
        PinyinTask pinyinTask = new PinyinTask();
        pinyinTask.setViewsList(viewsList);

        ThreadUtil.execute(() -> {
            log.info("任务已开始");
            pinyinTask.run();
            log.info("任务已结束");
        });
        resultSuccessMsg("任务已开始");
    }
}
