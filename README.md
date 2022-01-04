# -算法题更新

## 记录
### 剑指 Offer 55 - I. 二叉树的深度
#### 1月17日 
并没有写新的算法题。但是学会了用非递归的方式实现了 先序，中序，后序遍历


```java
public class Trees{
    public void pre(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + " ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

}
```

##leetcode配置
```java
//CodeFileConfig:
   $!velocityTool.camelCaseName(${question.titleSlug})


//CodeTemplate:
  package com.zzj.leetcode;
  public class $!velocityTool.camelCaseName(${question.titleSlug}){
      public static void main(String[] args) {
           Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
      }
            ${question.code}
  }


/**
* @description: $description$
* @param: $param$
* @return: $return$
* @author: $user$
* @date: $date$
*/
```
