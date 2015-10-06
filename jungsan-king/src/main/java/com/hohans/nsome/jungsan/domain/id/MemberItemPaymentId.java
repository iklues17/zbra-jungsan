package com.hohans.nsome.jungsan.domain.id;

import java.io.Serializable;

public class MemberItemPaymentId implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    public MemberItemPaymentId() {
    }

    public MemberItemPaymentId(String id) {
        this.id = id;
    }

    public String getIdString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MemberItemPaymentId other = (MemberItemPaymentId) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    boolean sameValueAs(MemberItemPaymentId other) {
        return other != null && this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return id;
    }
}
