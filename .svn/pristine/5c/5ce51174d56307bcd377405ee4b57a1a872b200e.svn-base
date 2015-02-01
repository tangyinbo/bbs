/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	config.uiColor = '#f1f2f6';//背景色
	config.removePlugins = 'resize';
   
    //config.skin = 'moonocolor';//皮肤
    //config.skin = 'moonocolor';
	//config.skin = 'office2013';
	//config.fullPage=true;//完整html
    config.protectedSource.push(/<(script)[^>]*>[\s\S]*<\/script>/ig);//过滤script标签
	config.font_names="宋体;楷体_GB2312;新宋体;黑体;隶书;幼圆;微软雅黑;Arial";//语言
    config.enterMode = CKEDITOR.ENTER_BR;//enter 换行
    config.shiftEnterMode = CKEDITOR.ENTER_P; //shift+enter  <p></p>
    config.toolbar = [
                  	{name:'smiley',items:[ 'Smiley']},
                  	{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
                  	{ name: 'tools', items: [ 'Maximize', 'ShowBlocks' ] },
                  	{ name: 'others', items: [ '-' ] },
                  ];
};
CKEDITOR.on('instanceReady', function (ev) {
    with (ev.editor.dataProcessor.writer) {
        setRules("p", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("h1", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("h2", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("h3", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("h4", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("h5", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("div", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("table", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("tr", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("td", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("iframe", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("li", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("ul", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("ol", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("button", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
        setRules("span", { indent: false, breakAfterOpen: false, breakBeforeClose: false });
    }
});
