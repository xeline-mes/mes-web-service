(function($)
{
    var cometd = $.cometd;

    $(document).ready(function()
    {
        function _connectionEstablished()
        {
            $('#body').append('<div>CometD Connection Established</div>');
        }

        function _connectionBroken()
        {
            $('#body').append('<div>CometD Connection Broken</div>');
        }

        function _connectionClosed()
        {
            $('#body').append('<div>CometD Connection Closed</div>');
        }

        var _connected = false;
        function _metaConnect(message)
        {
            if (cometd.isDisconnected())
            {
                _connected = false;
                _connectionClosed();
                return;
            }

            var wasConnected = _connected;
            _connected = message.successful === true;
            if (!wasConnected && _connected)
            {
                _connectionEstablished();
            }
            else if (wasConnected && !_connected)
            {
                _connectionBroken();
            }
        }

        function _metaHandshake(handshake)
        {
            if (handshake.successful === true)
            {
                cometd.batch(function()
                {
                    cometd.subscribe('/hello', function(message)
                    {
                        $('#body').append('<div>Restful WebService Response: ' + message.data.greeting + '</div>');
                    });
                    cometd.publish('/service/hello', { name: 'Hello World' });
                    cometd.subscribe('/useractivity', function(message)
                    {
                        $('#body').append('<div>Restful WebService Response: ' + message.data.userevent + '</div>');
                    });
                });
            }
        }

        $(window).unload(function()
        {
            cometd.disconnect(true);
        });

        var cometURL = location.protocol + "//" + location.host + config.contextPath + "/cometd";
        cometd.configure({
            url: cometURL,
            logLevel: 'debug'
        });

        cometd.addListener('/meta/handshake', _metaHandshake);
        cometd.addListener('/meta/connect', _metaConnect);

        cometd.handshake();
    });
})(jQuery);
