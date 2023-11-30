package designPatterm.command;

public interface ActivityPlayStatus {
    // 扣减积分
    void deducePoints();

    // 是否中奖
    boolean raffle();

    // 发放奖品
    void sendPrize();
}
