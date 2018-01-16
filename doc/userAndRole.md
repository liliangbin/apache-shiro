### 用户的信息和角色以及角色对应的权限
#### SysPermission  
  -  id 
  - name
  - resourceType //资源的类型，用于button 和 menu 
  - permission //权限
  
  - SysRolePermission  另外一张表   对应的是  
  - permission 和 
  - role 的id
 
#### sysRole 
  -  id
  -  角色
  - 描述
  - 是否的可以给用户应用
  
  - SysRolePermission //另外一张表
  - 描述  //角色----权限关系 。多对多的关系。
  - SysUserRole //另外一张表
  - 描述 //用户--角色关系定义  
#### userRole
  - 另外一张表
  - //一个用户具有多个角色
  