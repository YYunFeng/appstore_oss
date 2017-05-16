﻿/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	//Define changes to default configuration here. For example:
	config.language = 'zh-cn';
	config.uiColor = '#AADC6E';

    config.font_names = '宋体;楷体_GB2312;新宋体;黑体;隶书;幼圆;微软雅黑;Arial';

    config.toolbar = [
            ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
            ['Link','Unlink','Anchor'],
            ['Styles','Format','Font','FontSize'],
            ['TextColor','BGColor'],
            ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak']
    ];
};
