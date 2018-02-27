package com.apps.waziup.model;

/**
 * Defines hyperlinks for similar objects in the structure.
 * Use #getFirst and #getLast parameters for paging.
 */
public class ModelLinks {

    private ModelLink self;
    private ModelLink next;
    private ModelLink last;
    private ModelLink first;

    public String getSelf() {
        return self.href;
    }

    public String getLast() {
        return last.href;
    }

    public String getFirst() {
        return first.href;
    }

    public String getNext() {
        return next.href;
    }

    @Override
    public String toString() {
        return "ModelLinks{" +
                "self=" + self +
                ", next=" + next +
                ", last=" + last +
                ", first=" + first +
                '}';
    }

    class ModelLink {

        final String href;

        public ModelLink(String href) {
            this.href = href;
        }
    }
}
