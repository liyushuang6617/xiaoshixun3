package com.example.zuoye.bean;

import java.util.List;

public class PinBean {

    /**
     * body : {"result":[{"ParentID":0,"IsFree":0,"ClassFormat":2,"PartDuration":969,"PartSize":14,"ID":450,"WatchTime":0,"Children":[],"Url":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/classfile/0/PM129听罗永浩的锤子怎么敲？（吴思通）/PM129听罗永浩的锤子怎么敲？（吴思通）.mp3","Name":"听罗永浩的锤子怎么敲？"}]}
     * code : 200
     * message : Succes!
     */

    private BodyBean body;
    private int code;
    private String message;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BodyBean {
        private List<ResultBean> result;

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * ParentID : 0
             * IsFree : 0
             * ClassFormat : 2
             * PartDuration : 969
             * PartSize : 14
             * ID : 450
             * WatchTime : 0
             * Children : []
             * Url : https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/classfile/0/PM129听罗永浩的锤子怎么敲？（吴思通）/PM129听罗永浩的锤子怎么敲？（吴思通）.mp3
             * Name : 听罗永浩的锤子怎么敲？
             */

            private int ParentID;
            private int IsFree;
            private int ClassFormat;
            private int PartDuration;
            private int PartSize;
            private int ID;
            private int WatchTime;
            private String Url;
            private String Name;
            private List<?> Children;

            public int getParentID() {
                return ParentID;
            }

            public void setParentID(int ParentID) {
                this.ParentID = ParentID;
            }

            public int getIsFree() {
                return IsFree;
            }

            public void setIsFree(int IsFree) {
                this.IsFree = IsFree;
            }

            public int getClassFormat() {
                return ClassFormat;
            }

            public void setClassFormat(int ClassFormat) {
                this.ClassFormat = ClassFormat;
            }

            public int getPartDuration() {
                return PartDuration;
            }

            public void setPartDuration(int PartDuration) {
                this.PartDuration = PartDuration;
            }

            public int getPartSize() {
                return PartSize;
            }

            public void setPartSize(int PartSize) {
                this.PartSize = PartSize;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getWatchTime() {
                return WatchTime;
            }

            public void setWatchTime(int WatchTime) {
                this.WatchTime = WatchTime;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public List<?> getChildren() {
                return Children;
            }

            public void setChildren(List<?> Children) {
                this.Children = Children;
            }
        }
    }
}
