/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
    // 界面语言，默认为 'en'
    config.language = 'zh-cn';
    // 设置宽高
    config.width = 965;
    config.height = 210;
    config.uiColor = '#428bca';

    // 编辑器样式，有三种：'kama'（默认）、'office2003'、'v2'
//    config.skin = 'office2003';

    // 工具栏（基础'Basic'、全能'Full'、自定义）plugins/toolbar/plugin.js
    config.toolbar = 'Basic';
    config.toolbar = 'Full';

    config.toolbar_Full = [
        ['Source','Undo','Redo','Cut','Copy','Paste','Bold','Italic','Underline','Strike','NumberedList','BulletedList','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
        ['Link','Unlink','Image','Table','HorizontalRule','Smiley'],
        '/',
        ['Format','Font','FontSize'],
        ['TextColor','BGColor']
    ];

    //取消 “拖拽以改变尺寸”功能 plugins/resize/plugin.js
    config.resize_enabled = false;

    //自定义表情的放置目录
    config.smiley_path = 'ckeditor/plugins/smiley/images/';

    //表情显示每行个数
    config.smiley_columns = 11;

    //表情自定义
    //config.smiley_images  =  ['1.png','2.png','3.png','4.png','5.png','6.png','7.png','8.png','9.png','10.png','11.png','12.png','13.png','14.png'];

    //去掉左下角的body和p标签
    config.removePlugins = 'elementspath';

    config.enterMode = CKEDITOR.ENTER_BR;  //屏蔽换行符<br>
    config.shiftEnterMode = CKEDITOR.ENTER_P; //屏蔽段落<p>
};
