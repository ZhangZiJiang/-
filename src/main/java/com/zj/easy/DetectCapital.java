package com.zj.easy;

/**
 * @program algorithm
 * @description: 520. 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "FlaG"
 * 输出: False
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/03/19 00:18
 */
public class DetectCapital {
    public static void main(String[] args) {
        Solution solution = new DetectCapital().new Solution();
        System.out.println(solution.detectCapitalUse("HE0LO"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            char[] cs = word.toCharArray();
            int upper = 0;//大写字母个数
            int lower = 0;//小写字母个数
            for(int i=0;i<cs.length;i++) {
                if(cs[i]>='a') {
                    lower++;
                }else {
                    upper++;
                }
            }
            if(upper==cs.length) { //全大写
                return true;
            }
            if(lower==cs.length) {//全小写
                return true;
            }
            if(upper==1 && cs[0]<'a') {//首字母大写
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
