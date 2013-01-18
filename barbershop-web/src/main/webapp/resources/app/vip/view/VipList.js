Ext.define("VIP.view.VipList",{
	extend : 'Ext.grid.Panel',
	aligs : 'widget.vipList',
	title : '会员列表',
	
	columns: [
	      { header: '会员号',  dataIndex: 'vipNum'},
	      { header: '会员姓名', dataIndex: 'vipName'},
	      { header: '会员性别', dataIndex: 'vipSex'},
	      { header: '余额', dataIndex: 'account'}
	],
	
	store : 'VIP.store.VipStore'
});