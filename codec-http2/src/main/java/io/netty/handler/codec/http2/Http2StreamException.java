/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License, version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.netty.handler.codec.http2;

public class Http2StreamException extends Http2Exception {

    private static final long serialVersionUID = -7658235659648480024L;
    private final int streamId;

    public Http2StreamException(int streamId, Http2Error error, String message) {
        super(error, message);
        this.streamId = streamId;
    }

    public Http2StreamException(int streamId, Http2Error error, String message, Throwable cause) {
        super(error, message, cause);
        this.streamId = streamId;
    }

    public Http2StreamException(int streamId, Http2Error error) {
        super(error);
        this.streamId = streamId;
    }

    public int streamId() {
        return streamId;
    }

    public static Http2StreamException format(int id, Http2Error error, String fmt, Object... args) {
        return new Http2StreamException(id, error, String.format(fmt, args));
    }

    public static Http2StreamException streamClosedError(int id, String fmt, Object... args) {
        return format(id, Http2Error.STREAM_CLOSED, fmt, args);
    }
}
