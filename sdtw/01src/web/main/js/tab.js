$(function(){
    var $div_li = $("div.zytab_menu ul li");
    $div_li.mousemove(function(){
        $(this).addClass("selected").siblings().removeClass("selected");
        var index =  $div_li.index(this);  // ��ȡ��ǰ�����<li>Ԫ�� �� ȫ��liԪ���е�������
        $("div.zytab_box > div").eq(index).show().siblings().hide();
    });
});