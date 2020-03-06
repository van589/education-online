var App = function () {

    // iCheck
    var _masterCheckbox;
    var _checkbox;

    // 用于存放 ID 的数组
    var _idArray;

    /**
     * 私有方法，初始化 ICheck
     */
    var handlerInitCheckbox = function () {
        // 激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });

        // 获取控制端 Checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');

        // 获取全部 Checkbox 集合
        _checkbox = $('input[type="checkbox"].minimal');
    };

    /**
     * Checkbox 全选功能
     */
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            // 返回 true 表示未选中
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }

            // 选中状态
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    /**
     * 初始化 DataTables
     * @param url
     * @param columns
     * @returns {*}
     */
    var handlerInitDataTable = function (url, columns) {
        var _dataTable = $("#dataTable").DataTable({
            // 是否开启本地分页
            "paging": true,
            // 是否开启本地排序
            "ordering": false,
            // 是否显示左下角信息
            "info": true,
            // 是否允许用户改变表格每页显示的记录数
            "lengthChange": false,
            // 是否显示处理状态(排序的时候，数据很多耗费时间长的话，也会显示这个)
            "processing": true,
            // 是否允许 DataTables 开启本地搜索
            "searching": false,
            // 是否开启服务器模式
            "serverSide": true,
            // 控制 DataTables 的延迟渲染，可以提高初始化的速度
            "deferRender": true,
            // 增加或修改通过 Ajax 提交到服务端的请求数据
            "ajax": {
                "url": url
            },
            // 分页按钮显示选项
            "pagingType": "full_numbers",
            // 设置列的数据源
            "columns": columns,
            // 表格重绘的回调函数
            "drawCallback": function (settings) {
                //初始化多选框
                handlerInitCheckbox();
                //设置多选框全选
                handlerCheckboxAll();
            },
            // 国际化
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });

        return _dataTable
    };

    /**
     * 删除单笔记录
     * @param url 删除链接
     * @param id 需要删除数据的 ID
     */
    var handlerDeleteSingle = function (url, id, msg) {
        // 可选参数
        if (!msg) msg = null;

        // 将 ID 放入数组中，以便和批量删除通用
        _idArray = new Array();
        _idArray.push(id);

        $("#modal-message").html(msg == null ? "您确定删除数据项吗？" : msg);
        $("#modal-default").modal("show");
        // 绑定删除事件
        $("#btnModalOk").bind("click", function () {
            handlerAjaxData(url);
        });
    };

    /**
     * 批量删除
     * @param url
     */
    var handlerDeleteMulti = function (url) {

        //将前端用户信息的 ID 放入数组里
        idAarrayPush();

        // 判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        } else {
            $("#modal-message").html("您确定删除数据项吗？");
        }

        // 点击删除按钮时弹出模态框
        $("#modal-default").modal("show");

        // 如果用户选择了数据项则调用删除方法
        $("#btnModalOk").bind("click", function () {
            handlerAjaxData(url);
        });
    };

    /**
     * AJAX 异步操作删除数据
     * @param url
     */
    var handlerAjaxData = function (url) {
        $("#modal-default").modal("hide");

        if (_idArray.length > 0) {
            // AJAX 异步删除操作
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids": _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        defaultModelOk(data);
                    }
                });
            }, 500)
        }
    };

    /**
     * 查看用户详情信息
     * @param url
     */
    var handlerShowDetail = function (url) {
        // 这里是通过 Ajax 请求 html 的方式将 thymeleaf 装载进模态框中
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                //将用户信息页放入模态框中
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };

    /**
     * 余额充值
     * @param url
     */
    var handlerRecharge = function (url) {

        //将前端用户信息的 ID 放入数组里
        idAarrayPush();

        // 判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        } else {
            // 这里是通过 Ajax 请求 html 的方式将 thymeleaf 装载进模态框中
            $.ajax({
                url: url,
                type: "get",
                dataType: "html",
                success: function (data) {
                    //装载页面信息
                    $("#modal-message").html(data);
                }
            });
        }

        // 点击按钮时弹出模态框
        $("#modal-default").modal("show");

        // 如果用户选择了数据项则调用 异步更新余额数据 方法
        $("#btnModalOk").bind("click", function () {
            // 取出 input 里的值
            var rechargeInput = $("#rechargeInput").val();
            handlerRechargeDataUpdate(url, rechargeInput);
        });
    };

    /**
     * AJAX 异步更新余额数据
     * @param url
     */
    var handlerRechargeDataUpdate = function (url, rechargeInput) {
        $("#modal-default").modal("hide");

        if (_idArray.length > 0) {
            // AJAX 异步删除操作
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids": _idArray.toString(), "rechargeInput": rechargeInput},
                    "dataType": "JSON",
                    "success": function (data) {
                        defaultModelOk(data);
                    }
                });
            }, 500)
        }
    };

    /**
     * vip 时间设置
     * @param url
     */
    var handlerVipSettting = function (url) {

        //将前端用户信息的 ID 放入数组里
        idAarrayPush();

        // 判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        } else {
            // 这里是通过 Ajax 请求 html 的方式将 thymeleaf 装载进模态框中
            $.ajax({
                url: url,
                type: "get",
                dataType: "html",
                success: function (data) {
                    //装载页面信息
                    $("#modal-message").html(data);
                }
            });
        }

        // 点击按钮时弹出模态框
        $("#modal-default").modal("show");

        // 如果用户选择了数据项则调用 异步设置VIP时间数据 方法
        $("#btnModalOk").bind("click", function () {
            // 取出 input 里的值
            var vipSettingSelect = $("#vipSettingSelect").val();
            handlerVipSettingDataUpdate(url, vipSettingSelect);
        });
    };

    /**
     * AJAX 异步设置VIP时间数据
     * @param url
     * @param data
     */
    var handlerVipSettingDataUpdate = function (url, vipDate) {
        $("#modal-default").modal("hide");

        if (_idArray.length > 0) {
            // AJAX 异步删除操作
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids": _idArray.toString(), "vipDate": vipDate},
                    "dataType": "JSON",
                    "success": function (data) {
                        defaultModelOk(data);
                    }
                });
            }, 500)
        }
    };

    /**
     * 新增视频文件
     * @param url
     */
    var handlerCourseFileUpload = function (url) {
        // 这里是通过 Ajax 请求 html 的方式将 thymeleaf 装载进模态框中
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                //装载页面信息
                $("#modal-message").html(data);
            }
        });

        // 点击按钮时弹出模态框
        $("#modal-default").modal("show");

        // 如果用户点击确定则提交表单并隐藏模态框
        $("#btnModalOk").bind("click", function () {
            $('#btnSubmit').click();
            $("#modal-default").modal("hide");
        });
    };

    /**
     * 视频文件绑定课程
     * @param url
     */
    var handlerCourseFileBind = function (url) {
        //将前端用户信息的 ID 放入数组里
        idAarrayPush();
        //当只选择一个的情况下执行请求
        if (_idArray.length == 1) {
            // 这里是通过 Ajax 请求 html 的方式将 thymeleaf 装载进模态框中
            $.ajax({
                url: url,
                type: "get",
                "data": {"id": _idArray.toString()},
                dataType: "html",
                success: function (data) {
                    //装载页面信息
                    $("#modal-message").html(data);
                }
            });

            // 点击按钮时弹出模态框
            $("#modal-default").modal("show");

            // 如果用户点击确定则提交表单并隐藏模态框
            $("#btnModalOk").bind("click", function () {
                //当为绑定操作时进行下一步
                if(url == "/course/bind"){
                    handlerCourseFileBindToCourse(url);
                }
                //当为解绑的时候直接刷新页面
                else {
                    window.location.reload();
                }
            });
        }
        //没有选择课程
        else if (_idArray.length == 0) {
            //设置提示信息
            $("#modal-message").html("你还没选择课程");
            // 点击按钮时弹出模态框
            $("#modal-default").modal("show");
            // 如果用户点击确定则隐藏模态框
            $("#btnModalOk").bind("click", function () {
                $("#modal-default").modal("hide");
            });
        }
        //选择课程过多
        else {
            //设置提示信息
            $("#modal-message").html("只能选择一个课程");
            // 点击按钮时弹出模态框
            $("#modal-default").modal("show");
            // 如果用户点击确定则隐藏模态框
            $("#btnModalOk").bind("click", function () {
                $("#modal-default").modal("hide");
            });
        }
    };

    var handlerCourseFileBindToCourse = function (url) {
        $("#modal-default").modal("hide");
        var CourseFileId = $("#selectCourseFile").val();
        //如果没有视频ID则表明不需要更新
        if(CourseFileId != null){
            // AJAX 异步更新操作
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"CourseId": _idArray.toString(),"CourseFileId":CourseFileId.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        defaultModelOk(data);
                    }
                });
            }, 500)
        }
    };
    /**
     * Ajax异步请求成功后的模态框操作
     * @param data
     */
    var defaultModelOk = function (data) {
        // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件
        $("#btnModalOk").unbind("click");

        // 请求成功
        if (data.status === 200) {
            // 刷新页面
            $("#btnModalOk").bind("click", function () {
                window.location.reload();
            });
        }

        // 请求失败
        else {
            // 确定按钮的事件改为隐藏模态框
            $("#btnModalOk").bind("click", function () {
                $("#modal-default").modal("hide");
            });
        }

        // 因为无论如何都需要提示信息，所以这里的模态框是必须调用的
        $("#modal-message").html(data.message);
        $("#modal-default").modal("show");
    };

    /**
     * 将前端用户信息的 ID 放入数组里
     */
    var idAarrayPush = function () {
        _idArray = new Array();
        var _rechargeCollect = null;
        // 将选中元素的 ID 放入数组中
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });
    };

    return {
        /**
         * 初始化
         */
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        /**
         * 初始化 DataTables
         * @param url
         * @param columns
         * @returns {*}
         */
        initDataTables: function (url, columns) {
            return handlerInitDataTable(url, columns);
        },

        /**
         * 删除单笔数据
         * @param url
         */
        deleteSingle: function (url, id, msg) {
            handlerDeleteSingle(url, id, msg);
        },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },

        /**
         * 显示详情
         * @param url
         */
        showDetail: function (url) {
            handlerShowDetail(url);
        },

        /**
         * 余额充值
         * @param url
         */
        recharge: function (url) {
            handlerRecharge(url);
        },

        /**
         *设置 VIP 时间
         * @param url
         */
        vipSetting: function (url) {
            handlerVipSettting(url);
        },

        /**
         * 新增视频文件
         * @param url
         */
        courseFileUpload: function (url) {
            handlerCourseFileUpload(url);
        },

        /**
         * 视频文件绑定课程
         * @param url
         */
        courseFileBind: function (url) {
            handlerCourseFileBind(url);
        }

    }
}();

$(document).ready(function () {
    App.init();
});