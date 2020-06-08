import logging
import time

"""
假设现在需要生成 100 条 message， 每条需要1秒生成，然后再消费掉这些message 每消费一条也要1秒
请问下面的代码有什么优化的方案？
"""


def produce():
    message_list = []
    for i in range(100):
        time.sleep(1)
        message_list.append(str(i))

    return message_list


def consume(message_list):
    for m in message_list:
        time.sleep(1)
        logging.error('message:' + m + ' has been consumed')


if __name__ == '__main__':
    messages = produce()
    consume(messages)
