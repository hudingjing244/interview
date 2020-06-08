import logging

"""
请推测一下，下面的程序输出结果是什么？
"""


def test_iterator():
    nums = [1, 2, 3, 4]
    for i in nums:
        nums.remove(i)
    logging.info(nums)
