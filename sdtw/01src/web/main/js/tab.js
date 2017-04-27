$(function(){
    var $div_li = $("div.zytab_menu ul li");
    $div_li.mousemove(function(){
        $(this).addClass("selected").siblings().removeClass("selected");
        var index =  $div_li.index(this);  // 获取当前点击的<li>元素 在 全部li元素中的索引。
        $("div.zytab_box > div").eq(index).show().siblings().hide();
    });
});