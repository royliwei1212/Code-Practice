class Solution:
    """
    @param nums: an array
    @param k: an integer
    @return: three non-overlapping subarrays with maximum sum
    """

    def maxSumOfThreeSubarrays(self, nums, k):
        # Write your code here

        length = len(nums)
        pre_sum = [0]
        for i in range(0, length):
            pre_sum.append(pre_sum[i] + nums[i])

        left_max_index = [0] * length
        right_max_index = [0] * length
        max_sum = pre_sum[k] - pre_sum[0]
        for i in range(0, length):
            local_max = pre_sum[i + 1] - pre_sum[i + 1 - k]
            if local_max > max_sum:
                left_max_index[i] = i + 1 - k
                max_sum = pre_sum[i + 1] - pre_sum[i + 1 - k]
            else:
                left_max_index[i] = left_max_index[i - 1]

        right_max_index[length - k] = length - k
        max_sum = pre_sum[length] - pre_sum[length - k]
        for i in range(length - k - 1, -1, -1):
            local_max = pre_sum[i + k] - pre_sum[i]
            if local_max >= max_sum:
                right_max_index[i] = i
                max_sum = pre_sum[i + k] - pre_sum[i]
            else:
                right_max_index[i] = right_max_index[i + 1]

        ans = [0] * 3
        global_max = 0
        for i in range(k, length - 2 * k + 1):
            left = left_max_index[i - 1]
            right = right_max_index[i + k]
            local_max = (pre_sum[i + k] - pre_sum[i]) + (pre_sum[left + k] - pre_sum[left]) + (pre_sum[right + k] - pre_sum[right])
            if local_max > global_max:
                global_max = local_max
                ans[0] = left
                ans[1] = i
                ans[2] = right

        return ans
