Ext.define("VIP.store.VipStore",{
	
	storeId:'vipStroe',
    fields:['vipNum','vipName','vipSex','account'],
    data:{'items':[
        { 'vipNum': '20121111','vipName':'张三','vipSex':1,'account':20 },
        { 'vipNum': '20122222','vipName':'李四','vipSex':1,'account':40 },
        { 'vipNum': '20123333','vipName':'王五','vipSex':2,'account':50 },
        { 'vipNum': '20124444','vipName':'赵六','vipSex':3,'account':60 },
    ]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
	
	
});